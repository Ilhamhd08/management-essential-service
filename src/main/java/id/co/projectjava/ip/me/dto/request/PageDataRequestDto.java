package id.co.projectjava.ip.me.dto.request;

import id.co.projectjava.ip.me.dto.FilterDto;
import id.co.projectjava.ip.me.dto.SortingDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDataRequestDto {
    private List<SortingDto> sorting = new ArrayList<>();
    private List<FilterDto> filter = new ArrayList<>();

}
