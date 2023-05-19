package br.com.cod2d.api.domain.dto.bling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto2DTO {
    public String codigo;
    public String tipo;
    public String descricao;
    public String unidade;
    public String preco;
    public String precoCusto;
    public String pesoLiq;
    public String pesoBruto;
    public String estoqueMinimo;
    public Object estoqueMaximo;
    public String gtin;
    public String gtinEmbalagem;
    public String descricaoCurta;
    public String descricaoComplementar;
    public String larguraProduto;
    public String alturaProduto;
    public String profundidadeProduto;
    public String unidadeMedida;
    public String dataInclusao;
    public String dataAlteracao;
    public Object imageThumbnail;
    public String nomeFornecedor;
    public String marca;
    public String class_fiscal;
    public String cest;
    public String origem;
    public String idGrupoProduto;
    public String linkExterno;
    public String observacoes;
    public String grupoProduto;
    public int itensPorCaixa;
    public int volumes;
    public String urlVideo;
    public String localizacao;
    public String crossdocking;
    public int garantia;
    public String condicao;
    public String freteGratis;
    public String producao;
    public String dataValidade;
    public String descricaoFornecedor;
    public ArrayList<ImagemDTO> imagemDTO;
    public ProdutoLojaDTO produtoLojaDTO;
    public String codigopai;
    public int estoqueAtual;
    public ArrayList<Deposito> depositos;
}
