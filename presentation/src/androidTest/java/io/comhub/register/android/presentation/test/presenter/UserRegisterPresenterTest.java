/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.comhub.register.android.presentation.test.presenter;

import android.content.Context;
import android.test.AndroidTestCase;
import io.comhub.register.android.domain.user.interactor.GetUserDetails;
import io.comhub.register.android.presentation.mapper.UserModelDataMapper;
import io.comhub.register.android.presentation.presenter.UserDetailsPresenter;
import io.comhub.register.android.presentation.view.UserDetailsView;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class UserRegisterPresenterTest extends AndroidTestCase {

  private static final int FAKE_USER_ID = 123;

  private UserDetailsPresenter userDetailsPresenter;

  @Mock
  private Context mockContext;
  @Mock
  private UserDetailsView mockUserDetailsView;
  @Mock
  private GetUserDetails mockGetUserDetails;
  @Mock
  private UserModelDataMapper mockUserModelDataMapper;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);
    userDetailsPresenter = new UserDetailsPresenter(mockGetUserDetails,
                                                    mockUserModelDataMapper);
    userDetailsPresenter.setView(mockUserDetailsView);
  }

  public void testUserDetailsPresenterInitialize() {
    given(mockUserDetailsView.context()).willReturn(mockContext);

    userDetailsPresenter.initialize();

    verify(mockUserDetailsView).hideRetry();
    verify(mockUserDetailsView).showLoading();
    verify(mockGetUserDetails).execute(any(Subscriber.class));
  }
}
