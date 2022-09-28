package uz.tashkec.service;

import java.util.List;
import java.util.Optional;
import uz.tashkec.domain.Album;

/**
 * Service Interface for managing {@link Album}.
 */
public interface AlbumService {
    /**
     * Save a album.
     *
     * @param album the entity to save.
     * @return the persisted entity.
     */
    Album save(Album album);

    /**
     * Updates a album.
     *
     * @param album the entity to update.
     * @return the persisted entity.
     */
    Album update(Album album);

    /**
     * Partially updates a album.
     *
     * @param album the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Album> partialUpdate(Album album);

    /**
     * Get all the albums.
     *
     * @return the list of entities.
     */
    List<Album> findAll();

    /**
     * Get the "id" album.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Album> findOne(Long id);

    /**
     * Delete the "id" album.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
