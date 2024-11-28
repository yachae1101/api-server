package com.yachae1101.apiserver.service;

import com.yachae1101.apiserver.entity.User;
import com.yachae1101.apiserver.dto.UserDTO;
import com.yachae1101.apiserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getUsers() {
        // Repository에서 모든 유저 데이터를 가져옴
        List<User> entitieList = userRepository.findAll();

        /* Entity를 DTO로 변환 */
        List<UserDTO> dtoList = new ArrayList<>();

        // 날짜 형식을 yyyy-MM-dd로 지정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // for문을 사용해 Entity를 DTO로 변환
        for (User entity : entitieList) {
            String formattedBirthday = null;
            if (entity.getBirthday() != null) {
                // Date를 String으로 변환
                formattedBirthday = simpleDateFormat.format(entity.getBirthday());
            }

            // UserDTO 객체 생성
            UserDTO dto = UserDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .phone(entity.getPhone())
                    .birthday(formattedBirthday)
                    .build();

            // dtoList에 추가
            dtoList.add(dto);
        }

        return dtoList;
    }
}
