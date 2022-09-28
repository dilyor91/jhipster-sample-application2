package uz.tashkec.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;
import uz.tashkec.domain.Popup;
import uz.tashkec.repository.PopupRepository;
import uz.tashkec.service.PopupService;
import uz.tashkec.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link uz.tashkec.domain.Popup}.
 */
@RestController
@RequestMapping("/api")
public class PopupResource {

    private final Logger log = LoggerFactory.getLogger(PopupResource.class);

    private static final String ENTITY_NAME = "popup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PopupService popupService;

    private final PopupRepository popupRepository;

    public PopupResource(PopupService popupService, PopupRepository popupRepository) {
        this.popupService = popupService;
        this.popupRepository = popupRepository;
    }

    /**
     * {@code POST  /popups} : Create a new popup.
     *
     * @param popup the popup to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new popup, or with status {@code 400 (Bad Request)} if the popup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/popups")
    public ResponseEntity<Popup> createPopup(@RequestBody Popup popup) throws URISyntaxException {
        log.debug("REST request to save Popup : {}", popup);
        if (popup.getId() != null) {
            throw new BadRequestAlertException("A new popup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Popup result = popupService.save(popup);
        return ResponseEntity
            .created(new URI("/api/popups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /popups/:id} : Updates an existing popup.
     *
     * @param id the id of the popup to save.
     * @param popup the popup to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated popup,
     * or with status {@code 400 (Bad Request)} if the popup is not valid,
     * or with status {@code 500 (Internal Server Error)} if the popup couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/popups/{id}")
    public ResponseEntity<Popup> updatePopup(@PathVariable(value = "id", required = false) final Long id, @RequestBody Popup popup)
        throws URISyntaxException {
        log.debug("REST request to update Popup : {}, {}", id, popup);
        if (popup.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, popup.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!popupRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Popup result = popupService.update(popup);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, popup.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /popups/:id} : Partial updates given fields of an existing popup, field will ignore if it is null
     *
     * @param id the id of the popup to save.
     * @param popup the popup to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated popup,
     * or with status {@code 400 (Bad Request)} if the popup is not valid,
     * or with status {@code 404 (Not Found)} if the popup is not found,
     * or with status {@code 500 (Internal Server Error)} if the popup couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/popups/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Popup> partialUpdatePopup(@PathVariable(value = "id", required = false) final Long id, @RequestBody Popup popup)
        throws URISyntaxException {
        log.debug("REST request to partial update Popup partially : {}, {}", id, popup);
        if (popup.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, popup.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!popupRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Popup> result = popupService.partialUpdate(popup);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, popup.getId().toString())
        );
    }

    /**
     * {@code GET  /popups} : get all the popups.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of popups in body.
     */
    @GetMapping("/popups")
    public List<Popup> getAllPopups() {
        log.debug("REST request to get all Popups");
        return popupService.findAll();
    }

    /**
     * {@code GET  /popups/:id} : get the "id" popup.
     *
     * @param id the id of the popup to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the popup, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/popups/{id}")
    public ResponseEntity<Popup> getPopup(@PathVariable Long id) {
        log.debug("REST request to get Popup : {}", id);
        Optional<Popup> popup = popupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(popup);
    }

    /**
     * {@code DELETE  /popups/:id} : delete the "id" popup.
     *
     * @param id the id of the popup to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/popups/{id}")
    public ResponseEntity<Void> deletePopup(@PathVariable Long id) {
        log.debug("REST request to delete Popup : {}", id);
        popupService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
