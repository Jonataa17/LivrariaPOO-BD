/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DAOFactory;
import dao.EditoraDAO;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author 182120038
 */
public class EditoraServicos {

    public void cadEditora(Editora cVO) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditoraDAO(cVO);
    }//fim cadEditora

    public void atualizarEditora(Editora cVO) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.atualizaEditoraByDoc(cVO);
    }//fim atualizarEditora

    public void deletarEditora(String cnpj) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.deletarEditoraDAO(cnpj);
    }//fim deletarEditora

    public Editora buscarEditoraByCNPJ(String cnpj) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getEditoraByDoc(cnpj);
    }//fim buscarEditoraByCNPJ

    public ArrayList<Editora> getEditoras() {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getEditoraDAO();
    }//fim ArrayList
}
