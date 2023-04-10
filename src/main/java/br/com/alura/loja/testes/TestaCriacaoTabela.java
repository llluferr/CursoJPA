package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestaCriacaoTabela {

    public static void main(String[] args) {
      popularBancoDeDados();
    }
    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
        Categoria videogames = new Categoria("VIDEOGAMES");
        Produto videogame = new Produto("PS5", "Muito caro", new BigDecimal("5000"), videogames );
        Categoria canetas = new Categoria("CANETAS");
        Produto caneta = new Produto("Caneta azul", "Caneta azul azul caneta esta marcada com minha letra", new BigDecimal("100000"), canetas );

        Cliente cliente = new Cliente("Rodrigo", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(canetas);
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(caneta);
        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
