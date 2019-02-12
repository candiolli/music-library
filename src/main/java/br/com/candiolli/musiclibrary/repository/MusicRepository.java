package br.com.candiolli.musiclibrary.repository;

import br.com.candiolli.musiclibrary.model.Music;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MusicRepository extends PagingAndSortingRepository<Music, Long> {

    List<Music> findByAlbumId(@Param("id") Long id);
	
}
