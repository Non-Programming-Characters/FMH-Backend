package ru.fmh.app.service.material;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.fmh.app.dao.MaterialDao;
import ru.fmh.app.repository.MaterialRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MaterialService {

    @NonNull MaterialRepository materialRepository;

    public MaterialDao createMaterial(String title, String shortDesc, String fullDesc, String source) {
        MaterialDao preparedMaterialDao = MaterialDao.builder()
                .id(UUID.randomUUID())
                .title(title)
                .shortDescription(shortDesc)
                .fullDescription(fullDesc)
                .sources(source)
                .createdAt(Instant.now())
                .build();
        return materialRepository.save(preparedMaterialDao);
    }

    public List<MaterialDao> getAllMaterials() {
        return materialRepository.findAll();
    }

    public MaterialDao getMaterial(UUID materialId) {
        return materialRepository.findById(materialId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
