package ezenweb.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 여러 엔티티가 공통으로 사용하는 필드에 대해 구성
@EntityListeners( AuditingEntityListener.class )
public class BaseTime {
    @CreatedDate
    protected LocalDateTime cdate;    // 레코드/엔티티 생성 날짜
    @LastModifiedDate
    protected LocalDateTime udate;    // 레코드/엔티티 수정 날짜


}

/*

    엔티티의 생성/수정 시간을 감지 후 자동 업데이트 해주는 클래스


 */
