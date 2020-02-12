package com.training.exercise.mapper;

import com.training.exercise.model.EmailMessage;
import com.training.exercise.model.dto.EmailMessageDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MessageMapper {
    EmailMessage createEntityFromEmailMessageDTO(EmailMessageDTO emailMessageDTO);
}
