//import controller.TartarugaControle;
//import view.TartarugaView;
import view.AquarioView;

public class App {
    public static void main(String[] args) {
        //TartarugaControle controller = new TartarugaControle(); //Usando AnimaisController
        //TartarugaView view = new TartarugaView();
        AquarioView aquario = new AquarioView();

        // Inicie a execução do programa chamando um método na exibir
        //view.exibirMenu();
        aquario.exibirMenuPrincipal();
    }
}

