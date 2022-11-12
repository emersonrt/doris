package com.emerson.doris.service;

import com.emerson.doris.dto.CandidatoDTO;
import com.emerson.doris.dto.converter.CandidatoConverter;
import com.emerson.doris.enums.DataCadastroEnum;
import com.emerson.doris.form.CandidatoForm;
import com.emerson.doris.form.HardSkillForm;
import com.emerson.doris.model.Candidato;
import com.emerson.doris.model.HardSkill;
import com.emerson.doris.repository.CandidatoRepository;
import com.emerson.doris.service.impl.CandidatoServiceImpl;
import com.emerson.doris.utils.FiltroPaginacaoSpec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CandidatoServiceTest {

    @InjectMocks
    private CandidatoServiceImpl candidatoService;

    @Mock
    private CandidatoRepository candidatoRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    void deveCadastrar() {

        //ARRANGE
        String teste = "teste";
        HardSkillForm hardSkillForm = new HardSkillForm();
        hardSkillForm.setHabilidade("teste");
        hardSkillForm.setTempoExperiencia(1f);
        Candidato candidato = new Candidato();
        candidato.setNome(teste);
        candidato.setAreaInteresse(teste);
        candidato.setHardSkills(Arrays.asList(new HardSkill()));
        CandidatoForm form = new CandidatoForm();
        form.setNome(teste);
        form.setAreaInteresse(teste);
        form.setHardSkills(Arrays.asList(hardSkillForm));
        Mockito.when(candidatoRepository.save(Mockito.any(Candidato.class))).thenReturn(candidato);

        //ACT
        candidatoService.cadastrar(form);

        //ASSERT
        ArgumentCaptor<Candidato> candidatoCaptor = ArgumentCaptor.forClass(Candidato.class);
        Mockito.verify(candidatoRepository).save(candidatoCaptor.capture());
        Mockito.verify(mapper).map(candidato, CandidatoDTO.class);
        Mockito.verify(mapper).map(Arrays.asList(hardSkillForm), new TypeToken<List<HardSkill>>() {
        }.getType());

        assertEquals(teste, candidatoCaptor.getValue().getNome());
        assertEquals(teste, candidatoCaptor.getValue().getAreaInteresse());
    }

    @Test
    void deveCadastrarComDadoNull() {

        //ARRANGE
        String teste = "teste";
        Candidato candidato = new Candidato();
        candidato.setNome(teste);
        candidato.setAreaInteresse(teste);
        CandidatoForm form = new CandidatoForm();
        form.setNome(teste);
        form.setAreaInteresse(teste);
        Mockito.when(candidatoRepository.save(Mockito.any(Candidato.class))).thenReturn(candidato);

        //ACT
        candidatoService.cadastrar(form);

        //ASSERT
        ArgumentCaptor<Candidato> candidatoCaptor = ArgumentCaptor.forClass(Candidato.class);
        Mockito.verify(candidatoRepository).save(candidatoCaptor.capture());
        Mockito.verify(mapper).map(candidato, CandidatoDTO.class);

        assertEquals(teste, candidatoCaptor.getValue().getNome());
        assertEquals(teste, candidatoCaptor.getValue().getAreaInteresse());
    }

    @Test
    void deveBuscarPaginado() {
        //ARRANGE
        List<Candidato> list = Arrays.asList(new Candidato(), new Candidato());
        Page<Candidato> candidatos = new PageImpl<Candidato>(list);

        Mockito.when(candidatoRepository.findAll(Mockito.any(Specification.class), Mockito.any(Pageable.class))).thenReturn(candidatos);

        MockedStatic<CandidatoConverter> mockedStatic = mockStatic(CandidatoConverter.class);
        Specification<Candidato> spec = FiltroPaginacaoSpec.getCandidatoPorFiltrosSpec(
                "",
                "",
                DataCadastroEnum.fromString(""),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        //ACT
        candidatoService.buscaPaginada(spec, PageRequest.of(0, 5));

        //ASSERT
        ArgumentCaptor<Specification> specCaptor = ArgumentCaptor.forClass(Specification.class);
        ArgumentCaptor<Pageable> pageCaptor = ArgumentCaptor.forClass(Pageable.class);
        Mockito.verify(candidatoRepository).findAll(specCaptor.capture(), pageCaptor.capture());

        mockedStatic.verify(() -> CandidatoConverter.convert(any()), times(2));
    }

    @Test
    void deveBuscarPorId() {
        //ARRANGE
        Candidato candidato = new Candidato();
        candidato.setNome("teste");
        candidato.setAreaInteresse("teste");
        Mockito.when(candidatoRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(candidato));

        //ACT
        candidatoService.buscarPorId(1l);

        //ASSERT
        Mockito.verify(candidatoRepository).findById(1l);
        Mockito.verify(mapper).map(candidato, CandidatoDTO.class);
    }

    @Test
    void deveBuscarPorIdComErroNaoEncontrado() {
        //ARRANGE
        Mockito.when(candidatoRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(null));
        //ACT ASSERT
        Assertions.assertThrows(ResourceNotFoundException.class, () -> candidatoService.buscarPorId(1l));
    }
}