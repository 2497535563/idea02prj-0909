package edu.soft.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class News {
    private String nId,nTid,nTitle,nAuthor,nCreateDate,nPicPath,nContent,nModifyDate,nSummary;


}
