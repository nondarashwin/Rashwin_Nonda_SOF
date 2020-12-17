import { render, screen } from '@testing-library/react';
import App from './App';
import {shallow} from 'enzyme'
import React from "react";
import checkproptypes from 'check-prop-types'
test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
test("class app test",()=>{
  const component=shallow(<App/>)
  const component1=component.find(".App")
  expect(component1.length).toBe(1)
})
