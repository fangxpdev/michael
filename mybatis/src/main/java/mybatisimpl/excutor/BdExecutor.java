package mybatisimpl.excutor;

import mybatisimpl.mapper.BdMapperData;

import java.util.List;

public interface BdExecutor {


    <E> List<E> execute(BdMapperData bdMapperData, Object[] args);

}
