package com.gold.tree.entiyi;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;

/**
 * Created by Lenovo on 2020/8/16.
 */
public class MarkdownSavePipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        try {

            String fileName = resultItems.get("fileName");
            String document = resultItems.get("content");
            String dir = resultItems.get("dir");
            Service.saveFile(document, fileName, dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
