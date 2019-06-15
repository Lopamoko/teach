# teach
Описание методов:

авторизация: 
URL  -  https://socialteach.herokuapp.com/login
Метод - POST
Параметры на вход: 
  public class UserDataTransferObject {
    private Long userId;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
}
На выходе - Тот же объект, что и на входе.

Регистрация:
URL - https://socialteach.herokuapp.com/registration
Метод - POST
Параметры на вход:
  public class UserDataTransferObject {
    private Long userId;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
}
На выходе - Тот же объект, что и на входе.

Получить курсы:
URL - https://socialteach.herokuapp.com/api/course
Метод - GET
Параметры на вход:
  public class PageRequest {
    private int size;
    private int page;
}
На выходе - стандартный респонс со страничкой курсов(Пагинация)
