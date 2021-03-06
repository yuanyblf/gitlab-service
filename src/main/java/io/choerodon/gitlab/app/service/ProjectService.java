package io.choerodon.gitlab.app.service;

import java.util.List;
import java.util.Map;

import org.gitlab4j.api.models.Project;


public interface ProjectService {

    /**
     * 通过项目名称创建项目
     *
     * @param groupId    组 Id
     * @param projectName 项目名
     * @param userId   用户Id
     * @return Project
     */
    Project createProject(Integer groupId, String projectName, Integer userId, boolean visibility);

    /**
     * 删除项目
     *
     * @param projectId 项目 id
     * @param userId  用户名
     */
    void deleteProject(Integer projectId, Integer userId);

    /**
     * 增加项目ci环境变量
     *
     * @param projectId  项目Id
     * @param key        变量key
     * @param value      变量值
     * @param protecteds 变量是否保护
     * @param userId   用户Id
     * @return Map
     */
    Map<String, Object> createVariable(Integer projectId,
                                       String key,
                                       String value,
                                       boolean protecteds,
                                       Integer userId);

    /**
     * 增加项目保护分支
     *
     * @param projectId        项目Id
     * @param name             分支名
     * @param mergeAccessLevel merge权限
     * @param pushAccessLevel  push权限
     * @param userId         userId
     * @return Map
     */
    Map<String, Object> createProtectedBranches(Integer projectId,
                                                String name,
                                                String mergeAccessLevel,
                                                String pushAccessLevel,
                                                Integer userId);

    /**
     * 更新项目
     *
     * @param project  项目Id
     * @param userId 用户Id
     * @return Project
     */
    Project updateProject(Project project, Integer userId);

    /**
     * 通过分支名查询保护分支
     *
     * @param projectId 项目Id
     * @param name      分支名
     * @param userId  用户名
     * @return Map
     */
    Map<String, Object> queryBranchByBranchName(Integer projectId, String name, Integer userId);

    /**
     * 查询保护分支列表
     *
     * @param projectId project id
     * @param userId  userId   optional
     * @return List
     */
    List<Map<String, Object>> listBranch(Integer projectId, Integer userId);

    /**
     * 通过分支名删除保护分支
     *
     * @param projectId 项目Id
     * @param name      分支名
     * @param userId  用户名
     */
    void deleteByBranchName(Integer projectId, String name, Integer userId);


    /**
     * 新增deploy keys
     *
     * @param projectId 项目Id
     * @param title   标题
     * @param key
     * @param canPush  是否可以push代码
     */
    void createDeployKey(Integer projectId, String title, String key, boolean canPush, Integer userId);
}
