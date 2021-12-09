import Controler.Servico;
import Entidades.Aluno;
import Entidades.Convidado;
import Entidades.Pesquisador;
import Entidades.Usuario;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Servico lab = new Servico();
        String opc, id, pass;
        Usuario select = null;
        while (true) {
            opc = null;
            select = lab._logar();
            //so passa pra baixo se login !=null
            while (!Objects.equals(opc, "932") && select != null) {
                if (select instanceof Pesquisador) {
                    lab.addLogs(select,"Login");
                    opc = JOptionPane.showInputDialog(null, """
                            --Adm--
                            1-Novo Entidades.Aluno
                            2-Novo Entidades.Convidado
                            3-Alterar Usuario
                            4-Remover Usuario
                            5-Inserir dado
                            6-Acessar dado
                            7-Consultar Log
                            8-Sair""");
                    switch (opc) {
                        case "1"://novo usuario
                            id = JOptionPane.showInputDialog(null, "Id-Entidades.Aluno");
                            pass = JOptionPane.showInputDialog(null, "Senha-Entidades.Aluno");
                            Usuario novoUser = new Aluno(id, pass);
                            lab.novoUsuario(novoUser);
                            lab.addLogs(select,"criou aluno " + novoUser.getId());
                            break;
                        case "2"://novo convidado
                            id = JOptionPane.showInputDialog(null, "Id-Entidades.Convidado");
                            pass = JOptionPane.showInputDialog(null, "Senha-Entidades.Convidado");
                            Usuario novoConv = new Convidado(id, pass);
                            lab.novoUsuario(novoConv);
                            lab.addLogs(select,"criou convidado " + novoConv.getId());
                            break;
                        case "3"://alterar usuario
                            lab.alterarUsuario();
                            lab.addLogs(select,"alterou o usuario");
                            break;
                        case "4": //remover usuario
                            lab.removeUsuario();
                            lab.addLogs(select,"removeu um usuario");
                            break;
                        case "5": // inserir dado
                            lab.inserirDado();
                            lab.addLogs(select,"inseriu um dado");
                            break;
                        case "6":
                            lab.acessarDados();
                            lab.addLogs(select,"acessou um dado");
                            break;
                        case "7":
                            lab.consultaLog();
                            lab.addLogs(select,"consultou o log");
                            break;
                        case "8":
                            lab.addLogs(select,"Logout");
                            opc = "932";
                            break;
                    }
                } else if (select instanceof Aluno) {
                    lab.addLogs(select,"Login");
                    opc = JOptionPane.showInputDialog(null, """
                            --Entidades.Aluno--
                            1-Acessar dados
                            2-Sair""");
                    switch (opc) {
                        case "1"://novo usuario
                            lab.acessarDados();
                            lab.addLogs(select,"acessou um dado");
                            break;
                        case "2":
                            opc = "932";
                            lab.addLogs(select,"Logout");
                            break;
                    }
                } else if (select instanceof Convidado) {
                    var time = lab.diferencaTime((Convidado) select);
                    if ((int) time < 60*5) { //expirado dps de 5 minutos
                        lab.addLogs(select,"Login");
                        opc = JOptionPane.showInputDialog(null, """
                                --Entidades.Convidado--
                                1-Acessar dados
                                2-Sair
                                TEMPO RESTANTE: 
                                """ +lab.diferencaTime((Convidado) select) +"/300 seg.");
                        switch (opc) {
                            case "1"://novo usuario
                                lab.addLogs(select,"acessou um dado");
                                lab.acessarDados();
                                break;
                            case "2":
                                lab.addLogs(select,"Logout");
                                opc = "932";
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Entidades.Convidado Expirado");
                        System.out.println("Entidades.Convidado expirado");
                        break;
                    }
                }
            }
        }
    }
}
