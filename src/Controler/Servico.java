package Controler;

import Entidades.Convidado;
import Entidades.Dados;
import Entidades.Pesquisador;
import Entidades.Usuario;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Servico {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Dados> dados;
    private ArrayList<String> logs;

    public Servico() {
        this.usuarios = new ArrayList<>();
        this.usuarios.add(new Pesquisador("adm", "adm"));
        this.dados = new ArrayList<>();
        this.logs = new ArrayList<>();
    }

    public Usuario _logar() {
        String id = JOptionPane.showInputDialog(null, "Tela de Login\nInfome o id:");
        String pass = JOptionPane.showInputDialog(null, "Tela de Login\nInforme a senha:");
        for (Usuario u : getUsuarios()) {
            if (id.equals(u.getId()) && pass.equals(u.getPass())) {
                System.out.println("Acesso autorizado!");
//                JOptionPane.showMessageDialog(null, "Acesso autorizado!");
                return u;
            } else {
//                this.userOn=null;
//                JOptionPane.showMessageDialog(null, "Acesso negado!");
            }
        }
        System.out.println("Acesso negado!");
        return null;
    }

    public boolean novoUsuario(Usuario user) {
        //testar se user existe
        for (var u : usuarios) {
            if (Objects.equals(u.getId(), user.getId())) {
                JOptionPane.showMessageDialog(null, "Id ja existe!");
                return false;
            }
        }
        //add de fato usuario no serviço
        usuarios.add(user);
        JOptionPane.showMessageDialog(null, "Entidades.Usuario inserido!");
        return true;
    }

    public void alterarUsuario() {
        String id, pass;
        //listar os usuarios//seleciona 1//set novo id e nova senha//
        String allusers = "";
        int cont = 0;
        String choose;
        for (var s : getUsuarios()) {
            allusers += cont + " - " + s.getId() + "\n";
            cont++;
        }
        choose = JOptionPane.showInputDialog(null, allusers);
        int number = Integer.parseInt(choose);
        Usuario alterar = getUsuarios().get(number);
        id = JOptionPane.showInputDialog(null, "Id-Entidades.Aluno");
        pass = JOptionPane.showInputDialog(null, "Senha-Entidades.Aluno");
        alterar.setId(id);
        alterar.setPass(pass);
        JOptionPane.showMessageDialog(null, "Entidades.Usuario alterado");
    }

    public void removeUsuario() {
        String id, pass;
        //listar os usuarios//seleciona 1//set novo id e nova senha//
        String allusers = "";
        int cont = 0;
        String choose;
        for (var s : getUsuarios()) {
            allusers += cont + " - " + s.getId() + "\n";
            cont++;
        }
        choose = JOptionPane.showInputDialog(null, allusers);
        int number = Integer.parseInt(choose);
        Usuario alterar = getUsuarios().get(number);
        getUsuarios().remove(alterar);
        JOptionPane.showMessageDialog(null, "Entidades.Usuario removido");
    }

    public void inserirDado() {
        String title = JOptionPane.showInputDialog(null, "Title-dado");
        String info = JOptionPane.showInputDialog(null, "Set-Info");
        Dados novoDado = new Dados(title, info);
        dados.add(novoDado);
    }

    public void acessarDados() {
        int cont = 0;
        for (Dados d : dados) {
            System.out.println(cont + " - " + d.getTitle());
            cont++;
        }
        ///
        String allTitles = "";
        cont = 0;
        for (Dados s : dados) {
            allTitles += cont + " - " + s.getTitle() + "\n";
            cont++;
        }
        ///
        String opc = JOptionPane.showInputDialog(null, allTitles);
        int opc2 = Integer.parseInt(opc);
        Dados curDado = dados.get(opc2);
        JOptionPane.showMessageDialog(null, curDado.getInfos());
    }

    public void addLogs(Usuario user, String action) {
        String log = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        log += user.getId() + " " + dtf.format(LocalDateTime.now())+ " " + action;
        logs.add(log);

    }

    public long diferencaTime(Convidado convidado) {
        Date d2 = new Date();
        var d1 = convidado.getDate();
        System.out.println((d2.getTime() - d1.getTime()) / 1000); //gives the time difference in seconds.
        return (d2.getTime() - d1.getTime()) / 1000;
    }

    public void consultaLog(){
        for(var l:logs){
            System.out.println(l);
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<String> getLogs() {
        return logs;
    }

}
