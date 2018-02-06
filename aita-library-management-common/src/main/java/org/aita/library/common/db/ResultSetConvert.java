package org.aita.library.common.db;

import java.sql.ResultSet;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public interface ResultSetConvert<E> {
    <E> E transfer(ResultSet resultSet);
}
