package teste;

import controller.Controller;
import view.View;

public class TesteLivraria {
    public static void main(String[] args) {
        View view = new View();
        
        Controller c = new Controller(view);
        c.atualizaTabelas();
    }
}
