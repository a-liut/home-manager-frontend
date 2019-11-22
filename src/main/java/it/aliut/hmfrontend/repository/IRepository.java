package it.aliut.hmfrontend.repository;

public interface IRepository<IdType, Type> {

    Type[] getAll();

    Type getById(IdType id);
}
