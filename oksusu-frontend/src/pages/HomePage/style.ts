import styled from 'styled-components';

export const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    position: relative;
    box-sizing: border-box;
`

// Frame 3013
export const TopWrapper = styled.div`
    background: #E3FAEB;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    max-width: 375px;
    min-height: 100vh;
    padding: 48px 16px;
    box-sizing: border-box;
    padding-bottom: 50px; /* This effectively increases the total height */

    @media (min-width: 376px) {
        max-width: 414px;
    }
`;


// Frame 3012
export const TitleWrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 328px;
    height: 124px;
    padding: 0;
    gap: 12px;
`;

// Text 친구의 아이디를 복사해주세요
export const TitleText = styled.div`
    width: 328px;
    height: 80px;
    font-size: 32px;
    font-weight: 900;
    line-height: 40px;
    text-align: center;
    color: #000000;
`;

// Text ID를 복사 후 초대장의 ‘가입하고 혜택받기’ 버튼을 누르면 쉽게 레플리에 가입할 수 있어요!
export const DescriptionText = styled.div`
    width: 328px;
    height: 32px;
    font-size: 12px;
    font-weight: 300;
    line-height: 16px;
    text-align: center;
    color: #2C9C74;
`;

// Frame 3014
export const ContentWrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    max-width: 328px;
    //padding-bottom: 100px;
    box-sizing: border-box;
`;

// Frame 3017
export const ContentWrapper2 = styled.div`
    min-width: 328px;
    min-height: 180px;
    width: auto;
    height: auto;
`;

// Frame 3016
export const IconWrapper = styled.div`
    margin-top: 60px;
    width: 122px;
    height: 90px;
    position: relative;
`;

// Frame 2645
export const TextBoxWrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 16px;
    gap: 12px;
    width: 328px;
    height: 90px;
    background: #FFFFFF;
    border-radius: 12px;
    box-sizing: border-box;
`;

// ‘이름은최대열글자까지’님의 ID
export const NicknameWrapper = styled.div`
    font-family: 'Min Sans', sans-serif;
    font-size: 14px;
    font-weight: 400;
    line-height: 18px;
    text-align: center;
    color: #777777;
`;

// reppley 1234
export const ReppleyIdWrapper = styled.div`
    font-family: 'Min Sans', sans-serif;
    font-size: 22px;
    font-weight: 700;
    line-height: 28px;
    text-align: center;
    color: #000000;
`;

// bottom button
export const ButtonWrapper = styled.div`
    position: fixed;
    bottom: 32px;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    max-width: 375px;
    height: 100px;
    padding: 16px 16px 32px 16px;
    gap: 16px;
    left: 50%;
    transform: translateX(-50%);
`;

// Basic Button
export const Button = styled.button`
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 16px;
    gap: 8px;
    width: 328px;
    height: 52px;
    background: #51D696;
    border-radius: 26px;
    border: none;
    font-family: 'Min Sans', sans-serif;
    font-weight: 700;
    font-size: 16px;
    line-height: 20px;
    color: #FFFFFF;
    cursor: pointer;
`;

export const SnackbarWrapper = styled.div`
    position: fixed;
    top: 75px;
    left: 50%;
    transform: translateX(-50%);
    z-index: 5000;
`;

