package id.co.projectjava.ip.me.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchRequestDto {
    private Long id;
    private boolean active = true;
    private boolean deleted = false;
}
