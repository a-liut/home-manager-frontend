package it.aliut.hmfrontend.repository;

/**
 * Interface for a generic Repository.
 *
 * @param <IdType> Type of the ID.
 * @param <Type>   Type of the value.
 */
public interface IRepository<IdType, Type> {

    Type[] getAll();

    Type getById(IdType id);
}
