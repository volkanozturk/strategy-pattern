package com.volkanozturk.strategypattern.strategypattern.dto.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author volkanozturk
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomRestError {
	private Integer status;
	private String message;
}
