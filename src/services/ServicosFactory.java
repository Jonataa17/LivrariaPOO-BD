/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author 182120038
 */
public class ServicosFactory {

    private static ClienteServicos cServicos = new ClienteServicos();

    public static ClienteServicos getClienteServicos() {
        return cServicos;
    }//fim ClienteServicos

    private static EditoraServicos eServicos = new EditoraServicos();

    public static EditoraServicos getEditoraServicos() {
        return eServicos;
    }//fim EditoraServicos

    private static LivroServicos lServicos = new LivroServicos();

    public static LivroServicos getLivroServicos() {
        return lServicos;
    }//fim LivroServicos

    private static VendaLivroServicos vlServicos = new VendaLivroServicos();

    public static VendaLivroServicos getVendaLivros() {
        return vlServicos;
    }//fim VendaLivroServicos

}
