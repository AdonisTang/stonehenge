package com.bornstone.stonehenge.tool.generator.manager;

import com.bornstone.stonehenge.tool.generator.entity.DatabaseEntity;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by King.Tang on 14-11-5.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@Service
public class DataBaseManager {
    private static final Logger logger = Logger.getLogger(DataBaseManager.class);

    public void save(DatabaseEntity databaseEntity) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(databaseEntity);
            saveToFile(databaseEntity.getPath(), json);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void saveToFile(String path, String content) throws IOException {
        if (!path.endsWith("project.define")) {
            path = path + "/project.define";
        }
        FileWriter fw = new FileWriter(path);
        fw.write(content, 0, content.length());
        fw.flush();
        fw.close();
    }

    public DatabaseEntity get(String path) {
        try {
            if (!path.endsWith("project.define")) {
                path = path + "/project.define";
            }
            String content = getContentFromFile(path);
            Gson gson = new Gson();
            return gson.fromJson(content, DatabaseEntity.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private String getContentFromFile(String path) throws IOException {
        StringBuffer content = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String data = br.readLine();
        while (data != null) {
            content.append(data);
            data = br.readLine();
        }
        return content.toString();
    }
}
