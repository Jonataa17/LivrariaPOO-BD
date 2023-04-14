/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOFactory;
import dao.LivroDAO;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author 182120038
 */
public class LivroServicos {

    public void cadLivro(Livro liVO) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.cadastrarLivroDAO(liVO);
    }//fim cadLivro

    public void atualizarLivro(Livro liVO) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.atualizaLivroDAO(liVO);
    }//fim atualizarLivro

    public void deletarLivro(String isbn) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.deletarLivroDAO(isbn);
    }//fim deletarLivro

    public Livro buscarLivroByISBN(String isbn) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getLivroByISBN(isbn);
    }//fim buscarLivroByISBN

    public ArrayList<Livro> getLivros() {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getLivroDAO();
    }//fim ArrayList

}
