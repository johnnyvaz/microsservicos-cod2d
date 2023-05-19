package br.com.cod2d.api.usecase.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Component
public class CodigoEan {
    private String codigoBarra;

    public CodigoEan(final String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public CodigoEan() {
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(final String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    //Métodos de verificação e validação do codigo de barras.
    public Boolean validar(final CodigoEan codigoBarra) {
        final boolean valido;

        if (validarEAN(codigoBarra.getCodigoBarra())) {
            final int digitoVerificador = obterDigitoVerificador(codigoBarra.getCodigoBarra());
            valido = calcularDigitoVerificador(
                    removerDigitoVerificador(codigoBarra
                            .getCodigoBarra())) == digitoVerificador;
        } else {
            valido = false;
        }

        return valido;
    }

    private List<Integer> obterNumeroPosicao(final String codigoBarra, final String imparOuPar) {
        final List<Integer> numeros = new ArrayList<>();

        for (int i = 0, posicao = 1; i < codigoBarra.length() - 1; i++) {
            if ((posicao % 2 != 0))
                numeros.add(Integer.parseInt(String.valueOf(codigoBarra
                        .charAt(imparOuPar.equals("impar") ? posicao - 1 : posicao))));

            posicao++;
        }

        return numeros;
    }

    private int somarNumeros(final List<Integer> numeros) {
        return numeros.stream().reduce(0, Integer::sum);
    }

    private String removerDigitoVerificador(final String codigoBarra) {
        return codigoBarra.substring(0, codigoBarra.length() - 1);
    }

    private int obterDigitoVerificador(final String codigoBarra) {
        return Integer.parseInt(String.valueOf(codigoBarra.charAt(codigoBarra.length() - 1)));
    }

    private boolean validarEAN(final String codigoBarra) {
        return (codigoBarra.length() == 13);
    }

    private int calcularDigitoVerificador(final String codigoBarra) {
        final int somaPar = somarNumeros(obterNumeroPosicao(codigoBarra, "par"));
        final int somaImpar = somarNumeros(obterNumeroPosicao(codigoBarra, "impar"));
        final int multiplicaPar = somaPar * 3;
        int resultado = somaImpar + multiplicaPar;
        int digitoVerificador = 0;
        int auxiliar = 0;

        while ((resultado % 10) != 0) {
            digitoVerificador++;
            resultado += digitoVerificador - auxiliar;
            auxiliar = digitoVerificador;
        }

        return digitoVerificador;
    }
}
