package br.edu.ifsp.poo.class7;

public class ControllerStringReverser {
    private StringReverser view;

    public ControllerStringReverser(StringReverser view) {
        this.view = view;
    }

    public void reverse(){
        final String input = view.getInput();
        StringBuilder sb = new StringBuilder(input);
        view.setResult(sb.reverse().toString());
    }
}
