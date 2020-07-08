
export const OSLCResourceShapePlugin = {
  wrapComponents: {
    Model: (OriginalComponent, system) => (props) => {
      const React = system.React;
      let expanded = true;
      const toggleCollapsed = ()=>{
        if(props.onToggle){
          props.onToggle(props.name,!expanded)
        }
        expanded = !expanded;
      }

      const properties = props.schema.get("properties");
      if(properties === undefined){ return null; }
      return (
        <div className="model-box">
          <span className="model">
            <span>
              { props.name && 
                <span onClick={toggleCollapsed} style={{ "cursor": "pointer" }}>
                  <span className="model-title">
                    <span className="model-title__text">  
                      Shape: "{props.name} Resource Shape"
                    </span>
                  </span>
                </span> }
              <span onClick={ toggleCollapsed } style={{ "cursor": "pointer" }}>
                <span className={ "model-toggle" + ( expanded ? "" : " collapsed" ) }></span>
              </span>
            </span>
          </span>
          <table>
              <thead>
                <tr>
                  <th>Prefixed Name</th>
                  <th>Occurs</th>
                  <th>Read-only</th>
                  <th>Value-type</th>
                  <th>Representation</th>
                  <th>Range</th>
                </tr>
              </thead>
              <tbody>
                {properties.entrySeq().map( ([key, value]) => 
                  <tr key={key}>
                    <td>{key}</td>
                    <td>{value.get('x-OSLC-Occurs')}</td>
                    <td>{value.get('x-OSLC-ReadOnly')}</td>
                    <td>{value.get('x-OSLC-ValueType')}</td>
                    <td>{value.get('x-OSLC-Representation')}</td>
                    <td>{value.get('x-OSLC-Range') ? value.get('x-OSLC-Range').map((item, index) => {
                      return (<div key={index}>{item}</div>)
                    }) : ""}</td>
                  </tr>
                  
                )}
              </tbody>
          </table>
        </div>
      )
    }
  }
}

export const OSLCEndpointPlugin = {
  wrapComponents: {
    operation: (OriginalComponent, system) => (props) => {
      let operationId = props.operation.get("operationId");
      let operations = system.specSelectors.operations();
      let operation = operations.filter(op => op.get("operation").get("operationId") === operationId).first();
      const React = system.React;
      return (
        <div>
          {
            operation.get("operation").get("x-OSLC-ServiceProviderCatalog")&&
            <div>Service Provider Catalog</div>
          }
          {
            operation.get("operation").get("x-OSLC-CreationFactory") &&
            <div>Creation Factory</div>
          }
          {
            operation.get("operation").get("x-OSLC-QueryCapability") &&
            <div>Query Capability</div>
          }
        <OriginalComponent {...props} />
        </div>
      )
    }
  }
}

export const RDFExamplePlugin = {
  wrapComponents: {
    RequestBody: (OriginalComponent, system) => (props) => {
      const React = system.React;
     
      return (
        <div>
          <div>Open</div>
          <OriginalComponent {...props} />
          <div>Close</div>

        </div>
      )
    }
  }
}