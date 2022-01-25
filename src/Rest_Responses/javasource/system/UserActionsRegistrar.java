package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(rest_responses.actions.Create____CUSTOM_RESPONSE.class);
    registrator.registerUserAction(rest_responses.actions.Create_200_OK.class);
    registrator.registerUserAction(rest_responses.actions.Create_201_CREATED.class);
    registrator.registerUserAction(rest_responses.actions.Create_202_ACCEPTED.class);
    registrator.registerUserAction(rest_responses.actions.Create_204_NO_CONTENT.class);
    registrator.registerUserAction(rest_responses.actions.Create_207_MULTI_STATUS.class);
    registrator.registerUserAction(rest_responses.actions.Create_400_BAD_REQUEST.class);
    registrator.registerUserAction(rest_responses.actions.Create_401_UNAUTHORIZED.class);
    registrator.registerUserAction(rest_responses.actions.Create_403_FORBIDDEN.class);
    registrator.registerUserAction(rest_responses.actions.Create_404_NOT_FOUND.class);
    registrator.registerUserAction(rest_responses.actions.Create_409_CONFLICT.class);
    registrator.registerUserAction(rest_responses.actions.Create_429_TOO_MANY_REQUESTS.class);
    registrator.registerUserAction(rest_responses.actions.Create_500_INTERNAL_SERVER_ERROR.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
