package ru.fmh.app.controller;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fmh.app.controller.request.CreateMaterialRequest;
import ru.fmh.app.dao.MaterialDao;
import ru.fmh.app.dto.material.MaterialDto;
import ru.fmh.app.dto.material.QuickMaterialDto;
import ru.fmh.app.service.material.MaterialService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/materials")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MaterialsController {

    @NonNull
    MaterialService materialService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<MaterialDto>> getMaterials() {
        List<MaterialDto> materialsDto = materialService.getAllMaterials().stream().map(material ->
            new MaterialDto(
                    material.getId(),
                    material.getTitle(),
                    material.getShortDescription(),
                    material.getFullDescription(),
                    material.getSources(),
                    material.getCreatedAt()
            )
        ).toList();
        return ResponseEntity.ok(materialsDto);
    }

    @GetMapping(value = "/{materialId}", produces = "applicatiuon/json")
    public ResponseEntity<MaterialDto> getMaterial(@PathVariable("materialId") UUID materialId) {
        MaterialDao materialDao = materialService.getMaterial(materialId);
        return ResponseEntity.ok(new MaterialDto(
                materialDao.getId(),
                materialDao.getTitle(),
                materialDao.getShortDescription(),
                materialDao.getFullDescription(),
                materialDao.getSources(),
                materialDao.getCreatedAt()
        ));
    }

    @GetMapping(value = "/{materialId}/quick", produces = "application/json")
    public ResponseEntity<QuickMaterialDto> getQuickMaterial(@PathVariable("materialId") UUID materialId) {
        MaterialDao materialDao = materialService.getMaterial(materialId);
        return ResponseEntity.ok(new QuickMaterialDto(
                        materialDao.getId(),
                        materialDao.getTitle(),
                        materialDao.getShortDescription(),
                        materialDao.getCreatedAt()
        ));
    }

    @PostMapping(value = "/process", produces = "application/json")
    public ResponseEntity<MaterialDto> createMaterial(@RequestBody CreateMaterialRequest createMaterialRequest) {
        MaterialDao materialDao = materialService.createMaterial(
                createMaterialRequest.getTitle(), createMaterialRequest.getShortDescription(),
                createMaterialRequest.getFullDescription(), createMaterialRequest.getSources()
        );
        return ResponseEntity.ok(new MaterialDto(
                materialDao.getId(),
                materialDao.getTitle(),
                materialDao.getShortDescription(),
                materialDao.getFullDescription(),
                materialDao.getSources(),
                materialDao.getCreatedAt()
        ));
    }
}
