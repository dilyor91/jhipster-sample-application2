package uz.tashkec.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.domain.Popup;
import uz.tashkec.repository.PopupRepository;
import uz.tashkec.service.PopupService;

/**
 * Service Implementation for managing {@link Popup}.
 */
@Service
@Transactional
public class PopupServiceImpl implements PopupService {

    private final Logger log = LoggerFactory.getLogger(PopupServiceImpl.class);

    private final PopupRepository popupRepository;

    public PopupServiceImpl(PopupRepository popupRepository) {
        this.popupRepository = popupRepository;
    }

    @Override
    public Popup save(Popup popup) {
        log.debug("Request to save Popup : {}", popup);
        return popupRepository.save(popup);
    }

    @Override
    public Popup update(Popup popup) {
        log.debug("Request to update Popup : {}", popup);
        return popupRepository.save(popup);
    }

    @Override
    public Optional<Popup> partialUpdate(Popup popup) {
        log.debug("Request to partially update Popup : {}", popup);

        return popupRepository
            .findById(popup.getId())
            .map(existingPopup -> {
                if (popup.getIsImage() != null) {
                    existingPopup.setIsImage(popup.getIsImage());
                }
                if (popup.getVideoUrl() != null) {
                    existingPopup.setVideoUrl(popup.getVideoUrl());
                }
                if (popup.getRedirectUrl() != null) {
                    existingPopup.setRedirectUrl(popup.getRedirectUrl());
                }

                return existingPopup;
            })
            .map(popupRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Popup> findAll() {
        log.debug("Request to get all Popups");
        return popupRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Popup> findOne(Long id) {
        log.debug("Request to get Popup : {}", id);
        return popupRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Popup : {}", id);
        popupRepository.deleteById(id);
    }
}
