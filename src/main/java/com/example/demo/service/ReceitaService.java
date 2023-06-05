package com.example.demo.service;

import com.example.demo.model.Receita;
import com.example.demo.model.ReceitaForm;
import com.example.demo.model.Tipo;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository repository;

    public Receita transformarReceita(ReceitaForm form){
        System.out.println(form.getImagesUrls());
        System.out.println(form.getIngredientes());
        System.out.println(form.getModoDepreparo());
        Receita receita = new Receita();
        receita.setNome(form.getNome());
        receita.setIngredientes(separarParaLista(form.getIngredientes()));
        receita.setImagesUrls(separarParaLista(form.getImagesUrls()));
        receita.setModoDepreparo(separarParaLista(form.getModoDepreparo()));

        receita.setDica(form.getDica());
        receita.setTipo(form.getTipo());
        return receita;
    }

    public List<String> separarParaLista(String s){
        System.out.println(s);
        String[] split = s.split("--");
        List<String> linhas = new ArrayList<>();
        linhas.addAll(List.of(split));
        return linhas;
    }

    public void salvar(Receita receita){
        repository.save(receita);
    }

    public Receita findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public List<Receita> findAll(){
        return repository.findAll();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Receita HomeReceita(){
        return gerarReceitaParaHome();
    }

    private Receita gerarReceitaParaHome(){
        String nome = "Minibolo de cenoura com calda de chocolate";
        List<String> ingredientes = new ArrayList<>();
        ingredientes.add("3 cenouras picadas");
        ingredientes.add("3 ovos");
        ingredientes.add("1 xícara (chá) de óleo");
        ingredientes.add("1/3 de xícara (chá) de leite");
        ingredientes.add("2 xícaras (chá) de açúcar");
        ingredientes.add("3 xícaras (chá) de farinha de trigo");
        ingredientes.add("1 colher (sopa) de fermento em pó");
        ingredientes.add("Óleo e farinha de trigo para untar");
        ingredientes.add("250g de chocolate meio amargo picado");
        ingredientes.add("1 caixa de creme de leite");
        ingredientes.add("Chocolate granulado a gosto");

        List<String> modoDePreparo = new ArrayList<>();
        modoDePreparo.add("No liquidificador, bata a cenoura, os ovos, o óleo, o leite e o açúcar até ficar homogêneo." +
                " Transfira para uma tigela, adicione a farinha e o fermento e misture com uma colher. ");
        modoDePreparo.add("Despeje a massa em forminhas de buraco no meio individuais untadas e enfarinhadas e coloque uma ao lado da outra em uma fôrma grande. Leve ao forno médio, preaquecido, por 20 minutos ou até dourar levemente.");
        modoDePreparo.add("Retire, deixe amornar e desenforme. Derreta o chocolate meio amargo em banho-maria e misture com o creme de leite. Espalhe sobre os bolinhos, decore com chocolate granulado e sirva.");

        List<String> url = new ArrayList<>();
        url.add("https://guiadacozinha.com.br/wp-content/uploads/2020/03/Minibolo-cenoura-calda-chocolate.jpg");
        Receita receita =  new Receita(nome, ingredientes, url, modoDePreparo, "dica", Tipo.LINHA1);

        if (repository.findByNome(receita.getNome()) == null ){
            salvar(receita);
        }
        return receita;
    }

}
