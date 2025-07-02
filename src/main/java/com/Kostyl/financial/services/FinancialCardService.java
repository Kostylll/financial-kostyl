package com.Kostyl.financial.services;
import com.Kostyl.financial.mapper.ObjectMapper;
import com.Kostyl.financial.model.Categories;
import com.Kostyl.financial.model.FinancialCard;
import com.Kostyl.financial.model.dtos.FinancialCardDTO;
import com.Kostyl.financial.repository.CategoriesRepository;
import com.Kostyl.financial.repository.FinancialCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.Kostyl.financial.mapper.ObjectMapper.map;
import static com.Kostyl.financial.mapper.ObjectMapper.mapList;
import java.util.List;

@Service
public class FinancialCardService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private FinancialCardRepository financialCardRepository;

    public List<FinancialCardDTO> GetAll(){
        return mapList(financialCardRepository.findAll(), FinancialCardDTO.class);
    }

    public FinancialCardDTO createCard(FinancialCardDTO dto) {
        FinancialCard entity = map(dto, FinancialCard.class);

        if (dto.getCategory() != null && dto.getCategory().getId() != null) {
            Categories cat = mapper.map(dto.getCategory(), Categories.class);
            entity.setCategory(cat);
        }

        FinancialCard saved = financialCardRepository.save(entity);

        return mapper.map(saved, FinancialCardDTO.class);
    }


    public FinancialCardDTO updateCard(FinancialCardDTO dto) {
        var entity = financialCardRepository.findById(dto.getId()).orElse(null);


        Long categoryId = dto.getCategory().getId();
        Categories category = categoriesRepository.findById(Math.toIntExact(categoryId))
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        entity.setCategory(category);
        entity.setCreationDate(dto.getCreationDate());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setPaid(dto.isPaid());

        var dtoCard = mapper.map(financialCardRepository.save(entity), FinancialCardDTO.class);
        return dtoCard;
    }


    public void deleteCard(Long id){
       financialCardRepository.deleteById(id);
    }
}
