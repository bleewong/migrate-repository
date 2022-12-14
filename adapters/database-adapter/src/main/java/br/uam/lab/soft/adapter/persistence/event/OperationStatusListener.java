package br.uam.lab.soft.adapter.persistence.event;

import br.uam.lab.soft.adapter.persistence.OperationStatusEntity;
import br.uam.lab.soft.adapter.persistence.SequenceGeneratorService;
import br.uam.lab.soft.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

@PersistenceAdapter
@RequiredArgsConstructor
public class OperationStatusListener extends AbstractMongoEventListener<OperationStatusEntity> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<OperationStatusEntity> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService
                    .generateSequence(OperationStatusEntity.SEQUENCE_NAME));
        }
    }


}
