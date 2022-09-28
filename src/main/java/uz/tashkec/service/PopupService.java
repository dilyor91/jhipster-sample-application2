package uz.tashkec.service;

import java.util.List;
import java.util.Optional;
import uz.tashkec.domain.Popup;

/**
 * Service Interface for managing {@link Popup}.
 */
public interface PopupService {
    /**
     * Save a popup.
     *
     * @param popup the entity to save.
     * @return the persisted entity.
     */
    Popup save(Popup popup);

    /**
     * Updates a popup.
     *
     * @param popup the entity to update.
     * @return the persisted entity.
     */
    Popup update(Popup popup);

    /**
     * Partially updates a popup.
     *
     * @param popup the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Popup> partialUpdate(Popup popup);

    /**
     * Get all the popups.
     *
     * @return the list of entities.
     */
    List<Popup> findAll();

    /**
     * Get the "id" popup.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Popup> findOne(Long id);

    /**
     * Delete the "id" popup.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
