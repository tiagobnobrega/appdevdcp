package br.com.lasa.dcpdesconformidades.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lasa.dcpdesconformidades.domain.Loja;
import br.com.lasa.dcpdesconformidades.domain.User;
import br.com.lasa.dcpdesconformidades.repository.LojaRepository;
import br.com.lasa.dcpdesconformidades.service.dto.LojaParaAvaliacaoDTO;
import br.com.lasa.dcpdesconformidades.service.mapper.LojaParaAvaliacaoMapper;

/**
 * Service Implementation for managing Loja.
 */
@Service
@Transactional
public class LojaService {

    private final Logger log = LoggerFactory.getLogger(LojaService.class);

    private final LojaRepository lojaRepository;

    private final LojaParaAvaliacaoMapper lojaParaAvaliacaoMapper;

    public LojaService(LojaRepository lojaRepository, LojaParaAvaliacaoMapper lojaParaAvaliacaoMapper) {
        this.lojaRepository = lojaRepository;
        this.lojaParaAvaliacaoMapper = lojaParaAvaliacaoMapper;
    }

    /**
     * Save a loja.
     *
     * @param loja the entity to save
     * @return the persisted entity
     */
    public Loja save(Loja loja) {
        log.debug("Request to save Loja : {}", loja);

        return lojaRepository.save(loja);
    }

    /**
     * Get all the lojas.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Loja> findAll(Pageable pageable) {
        log.debug("Request to get all Lojas");
        return lojaRepository.findAll(pageable);
    }

    /**
     * Get all the Loja with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<Loja> findAllWithEagerRelationships(Pageable pageable) {
        return lojaRepository.findAllWithEagerRelationships(pageable);
    }
    

    /**
     * Get one loja by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Loja> findOne(Long id) {
        log.debug("Request to get Loja : {}", id);
        return lojaRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the loja by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Loja : {}", id);
        lojaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<LojaParaAvaliacaoDTO> getLojasPermitidasParaAvaliacaoPara(User user) {
        return user.getLojas().stream().map(lojaParaAvaliacaoMapper::toDto).collect(Collectors.toList());
    }
}