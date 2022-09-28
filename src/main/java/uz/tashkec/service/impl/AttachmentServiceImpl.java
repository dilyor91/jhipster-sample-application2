package uz.tashkec.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.tashkec.domain.Attachment;
import uz.tashkec.repository.AttachmentRepository;
import uz.tashkec.service.AttachmentService;

/**
 * Service Implementation for managing {@link Attachment}.
 */
@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {

    private final Logger log = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment save(Attachment attachment) {
        log.debug("Request to save Attachment : {}", attachment);
        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment update(Attachment attachment) {
        log.debug("Request to update Attachment : {}", attachment);
        return attachmentRepository.save(attachment);
    }

    @Override
    public Optional<Attachment> partialUpdate(Attachment attachment) {
        log.debug("Request to partially update Attachment : {}", attachment);

        return attachmentRepository
            .findById(attachment.getId())
            .map(existingAttachment -> {
                if (attachment.getFileNameUz() != null) {
                    existingAttachment.setFileNameUz(attachment.getFileNameUz());
                }
                if (attachment.getFileNameRu() != null) {
                    existingAttachment.setFileNameRu(attachment.getFileNameRu());
                }
                if (attachment.getFileNameKr() != null) {
                    existingAttachment.setFileNameKr(attachment.getFileNameKr());
                }
                if (attachment.getPath() != null) {
                    existingAttachment.setPath(attachment.getPath());
                }
                if (attachment.getOriginalFileName() != null) {
                    existingAttachment.setOriginalFileName(attachment.getOriginalFileName());
                }
                if (attachment.getContentType() != null) {
                    existingAttachment.setContentType(attachment.getContentType());
                }
                if (attachment.getFileSize() != null) {
                    existingAttachment.setFileSize(attachment.getFileSize());
                }
                if (attachment.getSuffix() != null) {
                    existingAttachment.setSuffix(attachment.getSuffix());
                }
                if (attachment.getThumbnailFileName() != null) {
                    existingAttachment.setThumbnailFileName(attachment.getThumbnailFileName());
                }
                if (attachment.getBucketName() != null) {
                    existingAttachment.setBucketName(attachment.getBucketName());
                }

                return existingAttachment;
            })
            .map(attachmentRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Attachment> findAll() {
        log.debug("Request to get all Attachments");
        return attachmentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Attachment> findOne(Long id) {
        log.debug("Request to get Attachment : {}", id);
        return attachmentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Attachment : {}", id);
        attachmentRepository.deleteById(id);
    }
}
