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
package io.comhub.register.android.domain.user.interactor;

import io.comhub.register.android.domain.interactor.UseCase;
import io.comhub.register.android.domain.user.User;
import io.comhub.register.android.domain.executor.PostExecutionThread;
import io.comhub.register.android.domain.executor.ThreadExecutor;
import io.comhub.register.android.domain.user.UserRepository;
import javax.inject.Inject;
import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetUserList extends UseCase {

  private final UserRepository userRepository;

  @Inject
  public GetUserList(UserRepository userRepository, ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.userRepository = userRepository;
  }

  @Override
  public Observable buildUseCaseObservable() {
    return this.userRepository.users();
  }
}
