package br.com.cod2d.consumer.integration.factory;

public interface AbstractFactory<T> {

    T createDefault(String order);
}
