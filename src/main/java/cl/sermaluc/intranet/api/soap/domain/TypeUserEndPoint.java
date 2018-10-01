package cl.sermaluc.intranet.api.soap.domain;

import cl.sermaluc.intranet.model.soap.domain.type_user.GetAllTypeUserResponse;
import cl.sermaluc.intranet.model.soap.domain.type_user.GetTypeUserForIdRequest;
import cl.sermaluc.intranet.model.soap.domain.type_user.GetTypeUserForIdResponse;
import cl.sermaluc.intranet.model.soap.domain.type_user.TypeUserInfo;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TypeUserEndPoint {

    private static final String NAMESPACE_URI = "http://www.sermaluc.cl/soap/resources/type-user";

    //Injeccion del servicio.

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTypeUserForIdRequest")
    @ResponsePayload
    public GetTypeUserForIdResponse getArticle(@RequestPayload GetTypeUserForIdRequest request) {
        GetTypeUserForIdResponse response = new GetTypeUserForIdResponse();
        TypeUserInfo typeUserInfo = new TypeUserInfo();
        //BeanUtils.copyProperties(articleService.getArticleById(request.getArticleId()), articleInfo);
        typeUserInfo.setName("test");
        typeUserInfo.setDescription("test");
        typeUserInfo.setTypeUserId("asdlaksdlkasñd");
        response.setTypeUserInfo(typeUserInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTypeUserRequest")
    @ResponsePayload
    public GetAllTypeUserResponse getAllArticles() {
        GetAllTypeUserResponse response = new GetAllTypeUserResponse();
        List<TypeUserInfo> typeUserInfoList = new ArrayList<>();
        //List<Article> articleList = articleService.getAllArticles();
        TypeUserInfo info1 = new TypeUserInfo();
        info1.setName("TEst list 1");
        info1.setDescription("Test list descripcon 1");
        info1.setTypeUserId("1");
        typeUserInfoList.add(info1);

        TypeUserInfo info2 = new TypeUserInfo();
        info2.setName("TEst list 2");
        info2.setDescription("Test list descripcon 2");
        info2.setTypeUserId("2");
        typeUserInfoList.add(info2);
        response.getTypeUserInfo().addAll(typeUserInfoList);
        return response;
    }
}
