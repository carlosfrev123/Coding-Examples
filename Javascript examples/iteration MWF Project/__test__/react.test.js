import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import { mock } from 'jest';
import App from "../client/components/App";
import Login from "../client/components/Login";
import Signup from "../client/components/Signup";
import Dashboard from "../client/components/Dashboard";
import Main from "../client/components/main";

describe("Front-End Tests", () => {

  // ---------------------- APP TESTING ----------------------

  describe("<App/>", () => {
    it("App renders without error", () => {
      const appRender = render(
        <BrowserRouter>
          <App/>
        </BrowserRouter>
      )
      expect(appRender).not.toBeInstanceOf(Error);
    });
  });

  // ---------------------- LOGIN TESTING ----------------------

  describe("<Login/>", () => {
    let loginRender;
    let dummyUser;

    beforeEach(() => {
      dummyUser = {
        username: "dummyUsername",
        password: "dummyPassword",
      };
      loginRender = render(
        <BrowserRouter>
          <Login />
        </BrowserRouter>
      );
    });
    
    it("login page should not be null", () => {
      // console.log('CONTENTS: ',loginRender);
      expect(loginRender.container).not.toBeNull;
    });

    it("user should be able to input with username and password", () => {
      const usernameTextBox = loginRender.queryByPlaceholderText('Username');
      expect(usernameTextBox).toEqual(loginRender.getByRole("textbox"));
      const passwordTextBox = loginRender.queryByPlaceholderText('Password');
      expect(passwordTextBox).not.toBeNull;    
    });

    it("username type should be text and password type should be password", () => {
      const usernameTextBox = loginRender.queryByPlaceholderText('Username');
      const passwordTextBox = loginRender.queryByPlaceholderText('Password');
      expect(usernameTextBox.type).toEqual('text');
      expect(usernameTextBox.type).not.toEqual('password');
      expect(passwordTextBox.type).toEqual('password');
      expect(passwordTextBox.type).not.toEqual('text');
    });

    xit("if user info incorrect throw alert", () => {
      const usernameInput = loginRender.queryByPlaceholderText('Username');
      const passwordInput = loginRender.queryByPlaceholderText('Password');
      usernameInput.value = "notARegisteredUsername";
      passwordInput.value = "notARegisteredPassword";
      
      const mockAlert = jest.spyOn(window, "alert").mockImplementation(() => {});
      const loginButton = loginRender.container.querySelector("button");
      fireEvent.click(loginButton);

      expect(mockAlert).toHaveBeenCalledWith("Wrong Username/Password");
      mockAlert.mockRestore();


    });
  });

  // ---------------------- SIGN UP TESTING ----------------------

  describe("Signup tests", () => {
    let signupRender;
    let dummyUser;

    beforeEach(() => {
      dummyUser = {
        username: "dummyUsername",
        password: "dummyPassword",
      };
      signupRender = render(
        <BrowserRouter>
          <Signup />
        </BrowserRouter>
      );
    });

    it("page render without error -- compare screen vs signUpRender testing", () => {
      expect(signupRender).not.toBeInstanceOf(Error);


      // console.log('--------------- SIGNUP RENDER ---------------- : \n', signupRender);
      // console.log('--------------- SIGNUP RENDER FUNCTIONS ---------------- : \n', signupRenderFunctions);
      // console.log('--------------- SCREEN FUNCTIONS ---------------- : \n', screen);
      const { container, baseElement, ...signupRenderFunctions } = signupRender;
      expect(signupRenderFunctions).not.toEqual(screen);
      
      console.log(
        "The signupRenderFunctions will defer to the screen functions (screen has a function: logTestingPlaygroundURL which signupRenderFunctions does not contain)."
      );
    });

    it("sign up container not null", () => {
      // const formElement = signupRender.getAllByText("textbox");
      console.log(signupRender.container);
      const suContainer = signupRender.container;
      expect(suContainer).not.toBeNull;
      // expect(formElement).not.toBeNull;
    });
    
    it("sign up for contains user password name lastname and zip code placeholder fields", () => {
      expect(signupRender.queryByPlaceholderText('Enter First Name Here')).toBeInTheDocument;
      expect(signupRender.queryByPlaceholderText('Enter Last Name Here')).toBeInTheDocument;
      expect(signupRender.queryByPlaceholderText('Enter Username Here')).toBeInTheDocument;
      expect(signupRender.queryByPlaceholderText('Enter Password Here')).toBeInTheDocument;
      expect(signupRender.queryByPlaceholderText('Enter Zip Code Here')).toBeInTheDocument;

      expect(signupRender.queryByPlaceholderText('Enter asldasfda Code Here')).not.toBeInTheDocument;
      expect(signupRender.queryByPlaceholderText('asfdgawghqwefq')).toBeNull;
    });

    it("should have a valid submit button within the form", () => {
      const submitButton = signupRender.container.return; // should be null
      console.log(submitButton);
    });
  });

  // ---------------------- DASHBOARD TESTING ----------------------

  xdescribe("Dashoard tests", () => {
    let dashRender;
    beforeEach(() => {
      dashRender = render(
         <BrowserRouter>
            <Dashboard />
         </BrowserRouter>
      );
    });

    it("dashboard returns main", () => {
      const mainContainer = dashRender.container.getByRole("main");
      // expect(mainContainer).toBeInTheDocument();
      // console.log('dashRender: ----- \n ',dashRender);


      // console.log(dashRender);
      // console.log(screen);
      // console.log(mainContainer);
      // console.log(mainContainer);
    });

    xit("dashboard returns Header", () => {
      console.log(dashRender);
    });
  });
});

// describe('testDiv test', () => {
//   // beforeAll(() => {

//   // });
//   test('testingDiv', () => {
//     const testDivVar = render(<TestDiv />);
//     expect(testDivVar).not.toBeNull;
//   });
// });
