package com.phoenix.data.dto;

import com.phoenix.data.models.QuantityOperation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartUpdateDto {
    private Long userId;

    private Long itemId;

    private QuantityOperation quantityOp;
}
