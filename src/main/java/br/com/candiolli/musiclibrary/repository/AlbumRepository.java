package br.com.candiolli.musiclibrary.repository;

import br.com.candiolli.musiclibrary.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {
	
}
