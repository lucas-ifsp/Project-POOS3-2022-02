package br.edu.ifsp.poo.practical03.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DatabaseBuilder {

    public static void main(String[] args) throws SQLException, IOException {
        dropDatabaseIfExists();
        createTables();
        populate();
        System.out.println("\n\u2764 Tudo pronto \u2764");
    }

    private static void dropDatabaseIfExists() throws IOException {
        final Path path = Paths.get("database.db");
        if(Files.exists(path)) {
            Files.delete(path);
            System.out.println("Removendo banco de dados existente...");
        }
    }

    private static void createTables() throws SQLException {
        final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        final Statement stmt = connection.createStatement();
        String sqlDeclaracao = """
                CREATE TABLE declaracao(
                    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    ganho_tributavel REAL,
                    valor_pago REAL,
                    tipo TEXT NOT NULL
                )
                """;
        String sqlGasto = """
                CREATE TABLE gasto(
                    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                    cnpj TEXT NOT NULL,
                    descricao TEXT NOT NULL,
                    valor REAL,
                    tipo TEXT NOT NULL,
                    instituicao_registro TEXT NOT NULL,
                    id_declaracao TEXT,
                    FOREIGN KEY (id_declaracao) REFERENCES declaracao(id)
                )
                """;
        System.out.println("Gerando novas tabelas...\n");
        stmt.executeUpdate(sqlDeclaracao);
        System.out.println(sqlDeclaracao);
        stmt.executeUpdate(sqlGasto);
        System.out.println(sqlGasto);
        stmt.close();
        connection.close();
    }

    private static void populate() throws SQLException {
        final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        final Statement stmt = connection.createStatement();

        System.out.println("Populando a tabela <<declaracao>> com as declarações simplificada (ID 1) e completa (ID 2)...");
        final String sql = "INSERT INTO declaracao (ganho_tributavel, valor_pago, tipo) VALUES (%.2f, %.2f, '%s')";

        stmt.addBatch(String.format(sql, 0.0, 0.0, "COMPLETA"));
        stmt.addBatch(String.format(sql, 0.0, 0.0, "SIMPLIFICADA"));
        stmt.executeBatch();

        stmt.close();
        connection.close();
    }
}
