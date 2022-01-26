package uff.ic.lleme.tcc00328.s20212.prova.p2.ArthurAlves.Q1;

public class SistemaGestor {
    
    public static Dicionario dict = new Dicionario();
    
    public static void main(String[] args) {
        String grafia1 = "obra";
        String grafia2 = "livro";
        
        String[] significado1 = {"aquilo que resulta de um trabalho, de uma ação.", "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
    "documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."};
        
        String[] significado2 = {"coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por\n" +
    "meio de cola, costura etc., formando um volume que se recobre com capa resistente.", "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
    "documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."};
        
        dict.adicionaPalavra(grafia1, significado1);
        dict.adicionaPalavra(grafia2, significado2);
        dict.mostraPalavras();
    }
    
}