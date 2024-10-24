package ddt_config;

import java.util.List;
import java.util.Map;

public interface DataReader {
    public List<Map<String, String>> getAllRows();
    public Map<String, String> getASingleRow();
    public List<String> getExcelDataWithRespectToColumn();
}
