package br.com.candiolli.musiclibrary.repository;

import br.com.candiolli.musiclibrary.model.Productor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "album-productor", path = "album-productor")
public interface ProductorRepository extends PagingAndSortingRepository<Productor, Long> {
}
